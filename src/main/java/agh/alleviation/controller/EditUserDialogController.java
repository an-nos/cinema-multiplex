package agh.alleviation.controller;

import agh.alleviation.model.user.User;
import agh.alleviation.service.UserService;
import agh.alleviation.util.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controller responsible for modal with user editing (support only adding at the moment)
 *
 * @author Kamil Krzempek
 */
@Component
@FxmlView("/views/EditUserDialog.fxml")
public class EditUserDialogController {
    /**
     * The User service.
     */
    UserService userService;

    /**
     * User instance on which controller is operating
     */
    User user;

    /**
     * Stage on which modal is placed
     */
    private Stage dialogStage;

    /**
     * Sets dialog stage.
     *
     * @param dialogStage the dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Instantiates a new Edit user dialog controller.
     *
     * @param userService the user service
     */
    @Autowired
    public EditUserDialogController(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private ChoiceBox<UserType> userTypeDropdown;

    @FXML
    private TextField nameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField emailField;

    /**
     * Initialize fields of form
     */
    @FXML
    private void initialize() {
        userTypeDropdown.getItems().addAll(UserType.values());
        userTypeDropdown.setValue(UserType.CUSTOMER);
    }

    @FXML
    private void addUser() {
        this.user = this.userService.addUser(nameField.getText(),
                                             loginField.getText(),
                                             emailField.getText(),
                                             userTypeDropdown.getValue()
        );
        dialogStage.close();
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return this.user;
    }
}