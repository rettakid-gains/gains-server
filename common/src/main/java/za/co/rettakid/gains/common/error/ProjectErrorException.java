package za.co.rettakid.gains.common.error;

import org.apache.log4j.Logger;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
public class ProjectErrorException extends RuntimeException {

    private static final Logger LOGGER = Logger.getLogger(ProjectErrorException.class);
    private ProjectError projectError;

    public ProjectErrorException(ProjectError projectError) {
        super(projectError.getError());
        this.projectError = projectError;
        LOGGER.error(projectError.getError());
    }

    public ProjectErrorException(ProjectError projectError, Throwable throwable) {
        super(projectError.getError(),throwable);
        this.projectError = projectError;
        LOGGER.error(projectError.getError(), throwable);
    }

    public ProjectErrorException(ProjectError projectError, Throwable throwable, String message) {
        super(projectError.getError(),throwable);
        this.projectError = projectError;
        LOGGER.error(message, throwable);
    }

    public ProjectError getProjectError() {
        return projectError;
    }
}
