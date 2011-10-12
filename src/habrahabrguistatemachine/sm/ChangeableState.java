/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package habrahabrguistatemachine.sm;

/**
 * State that can be changed over time, e.g. state showing progress of some action
 * @author __nocach
 */
public abstract class ChangeableState<T> extends BaseGuiState {
    private T value;
    public ChangeableState(){}
    public ChangeableState(T value){
        this.value = value;
    }
    protected abstract void valueChanged(T newValue);
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
        valueChanged(value);
    }
    
}
