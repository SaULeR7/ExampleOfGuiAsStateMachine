/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package habrahabrguistatemachine.sm;

/**
 *
 * @author __nocach
 */
public interface GuiState {
	/**
	 * called when entering to this state
	 */
    public void enterState();
    /**
	 * called when leaving this state
	 */
    public void leaveState();
}
