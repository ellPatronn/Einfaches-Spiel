import controller.GewinnController;
import model.GewinnModel;
import view.GewinnView;

public class Main {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
