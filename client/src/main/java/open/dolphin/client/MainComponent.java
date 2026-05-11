package open.dolphin.client;

import jakarta.swing.JPanel;

/**
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 */
public interface MainComponent extends MainTool {
    
    public String getIcon();
    
    public void setIcon(String icon);
    
    public JPanel getUI();
    
    public void setUI(JPanel panel);
    
}
