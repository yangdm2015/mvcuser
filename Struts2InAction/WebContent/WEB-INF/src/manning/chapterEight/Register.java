package manning.chapterEight;

import java.util.Map;

import manning.chapterEight.utils.Portfolio;
import manning.chapterEight.utils.PortfolioService;
import manning.chapterEight.utils.Struts2PortfolioConstants;
import manning.chapterEight.utils.User;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This is our first version of the Register action.  This version uses
 * the basic validation and message localization services provided by the 
 * ActionSupport help class.  By extending this class, we automatically
 * receive implementations of several interfaces that allow us to do
 * validation and localize our message texts with out polluting the
 * execute() method of our action.   
 */

public class Register extends ActionSupport implements SessionAware {

	public String execute() {

		/*
		 * Create and move the data onto our application domain object, user.
		 */
		User user = new User();
		user.setPassword(getPassword());
		Portfolio newPort = new Portfolio();
		newPort.setName(getPortfolioName());
		user.getPortfolios().put(newPort.getName(), newPort);
		user.setUsername(getUsername());
		user.setReceiveJunkMail(isReceiveJunkMail());
		System.out.println("junkmail = " + isReceiveJunkMail());

		getPortfolioService().createAccount(user);
		session.put(Struts2PortfolioConstants.USER, user);

		return SUCCESS;
	}

	/* JavaBeans Properties to Receive Request Parameters */

	private String username;
	private String password;
	private String portfolioName;
	private boolean receiveJunkMail;

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isReceiveJunkMail() {
		return receiveJunkMail;
	}

	public void setReceiveJunkMail(boolean receiveJunkMail) {
		this.receiveJunkMail = receiveJunkMail;
	}

	/*
	 * Validateable Implementation
	 * 
	 * The validate method validates, invoked by the validation interceptor in
	 * the default stack, will validate the data already set on the action by
	 * the params interceptor, also in the default stack.
	 * 
	 * If this method finds problems in validation it stores error messages via
	 * the methods exposed by the ValidationAware interface -- already
	 * implemented by the ActionSupport class that this action extends. To
	 * complete the the validation process, the workflow interceptor fires next
	 * in the default stack. It checks for error messages on the action, and if
	 * it finds them it diverts workflow back to the input page where the error
	 * messages are displayed to the user. In this case, the execute method of
	 * the action will not be called because the workflow was diverted, due to
	 * validation problems, before execution reached the action itself.
	 * 
	 */

	public void validate() {

		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();

		/* Check that fields are not empty */
		if (getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
		if (getUsername().length() == 0) {
			addFieldError("username", getText("username.required"));
		}
		if (getPortfolioName().length() == 0) {
			addFieldError("portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if (ps.userExists(getUsername())) {
			addFieldError("username", getText("user.exists"));
		}

	}

	/*
	 * Simple way to retrieve our business logic and data persistence object.
	 * Late versions of the portfolio app will integrate with more
	 * sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

	private Map session;

	public void setSession(Map session) {

		this.session = session;
	}

}
