import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by tonkosi on 07.01.15..
 */


public class Application {

    private StateManager mStateManager;

    public Application() {

    }

    public void init() {
        mStateManager = new StateManager();
        mStateManager.pushState(new MenuState());
        mStateManager.pushState(new GameState());

        // po DEFAULTU je selektiran ZADNJI dodani state
        mStateManager.changeState("MenuState");
    }

    public void run() {
        System.out.println("kaj ima njofra");
        mStateManager.getState().update(1);
        SetUpGL();
        loop();
    }

    public void loop() {
        // ovo bi se kasnije moglo zamijeniti s while (window opened())
        // ili necim slicno tome
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);

            Display.update();
            Display.sync(60);
        }
    }



    public void SetUpGL(){

        try {
            Display.setDisplayMode(new DisplayMode(Krapina.width, Krapina.height));
            Display.setResizable(false);
            Display.create();
        } catch (LWJGLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        glMatrixMode(GL_PROJECTION);
        glOrtho(0, Krapina.width, 0, Krapina.height, -1, 1);
        glMatrixMode(GL_MODELVIEW);


    }

    public void kill() {

    }
}
