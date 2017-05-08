package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Kalvador
 * @author Wilk
 */
public class ContentPane extends JPanel {

    private window.Obstacles obstacles;
    private window.Grid grid;
    private matrix.Matrix<Short> matrix;
    
    public static boolean isGrid = false;
    
    public ContentPane(matrix.Matrix<Short> matrix, utils.Camera camera) {
        
        this.matrix = matrix;
        obstacles = new Obstacles(matrix);
        grid = new Grid(matrix);

        /**
         * setup size of scrolledPane to size of matrix multiplied by dimension
         * of every rectangle
         */
        setPreferredSize(new Dimension(camera.contentPaneWidth, camera.contentPaneHeight));
        setOpaque(true); // nie wiem co to robi ale było więc niech zostanie
    }

    public void updateContentPane(){
        obstacles.updateObstacles();
        grid.updateGrid();
    }
    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);// nie wiem co to robi ale było więc nie ch zostanie

        Graphics2D g = (Graphics2D) graphics;

        obstacles.drawOBstacles(matrix, g);
        if(window.ContentPane.isGrid){
            grid.drawGrid(matrix.getWidth(), matrix.getHeight(), g);
        }
    }
}