package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        // TODO: save the DAO and Presenter in the instance variables.
        userDataAccessObject = userDataAccessInterface;
        logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // Get the username of the user who is logging out
        String username = userDataAccessObject.getCurrentUsername();

        // Set the current username to null
        userDataAccessObject.setCurrentUsername(null);

        // Instantiate the LogoutOutputData
        LogoutOutputData logoutOutputData =
                new LogoutOutputData(username);

        // Tell the presenter to prepare the success view
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

