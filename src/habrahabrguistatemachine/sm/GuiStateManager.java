/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package habrahabrguistatemachine.sm;

/**
 * State machine of swing gui
 * @author __nocach
 */
public class GuiStateManager {
    private GuiState currentState = new EmptyState();
    public synchronized void switchTo(GuiState newState){
        if (newState == null){
            throw new NullPointerException();
        }
        currentState.leaveState();
        currentState = newState;
        currentState.enterState();
    }
    public GuiState current(){
        return currentState;
    }
}
