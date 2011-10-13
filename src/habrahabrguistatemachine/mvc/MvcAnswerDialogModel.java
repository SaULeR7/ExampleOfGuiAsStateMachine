package habrahabrguistatemachine.mvc;

import habrahabrguistatemachine.PrepareToAnswerMeaningOfLife;
import habrahabrguistatemachine.RetrieveMeaningOfLife;
import habrahabrguistatemachine.domain.MeaningOfLifeAnswerer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.SwingWorker.StateValue;
/**
 * model for the dialog. Will notify listener passed in the constructor about changes of it state.
 * 
 * @author __nocach
 *
 */
public class MvcAnswerDialogModel {
	private MvcAnswerDialogModelListener listener;
	private MeaningOfLifeAnswerer meaningOfLifeAnswerer;
	public MvcAnswerDialogModel(MvcAnswerDialogModelListener listener){
		if (listener == null){
			throw new NullPointerException("listener can't be null");
		}
		this.listener = listener;
	}
	
	public void prepare(){
		final PrepareToAnswerMeaningOfLife prepareWorker = new PrepareToAnswerMeaningOfLife();
		prepareWorker.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("state".equals(evt.getPropertyName())){
					if (StateValue.STARTED.equals(evt.getNewValue())){
						listener.onPreparingStarted();
					}
					if (StateValue.DONE.equals(evt.getNewValue())){
						try {
							meaningOfLifeAnswerer = prepareWorker.get();
							listener.onPreparedSuccess();
						} catch (Exception e) {
							listener.onPreparedFailure();
						}
					}
				}
			}
		});
		prepareWorker.execute();
	}
	
	public void answerTheQuestion(){
		if (meaningOfLifeAnswerer == null){
			throw new IllegalStateException("meaningOfLifeAnswerer is null. You must call prepare before " +
					" invoking this method");
		}
		RetrieveMeaningOfLife retrieveWorker = new RetrieveMeaningOfLife(meaningOfLifeAnswerer);
        retrieveWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())){
                    listener.onSearchingProgress((Integer)evt.getNewValue());
                }
                if ("state".equals(evt.getPropertyName())){
                	if (StateValue.STARTED.equals(evt.getNewValue())){
                		listener.onSearchingStarted();
                	}
                    if (StateValue.DONE.equals(evt.getNewValue())){
                        RetrieveMeaningOfLife worker = (RetrieveMeaningOfLife)evt.getSource();
                        try{
                            Integer answer = worker.get();
                            listener.onSearchCompleteSuccess(answer);
                        }
                        catch(Exception ex){
                        	listener.onSearchCompleteFailure();
                        }
                    }
                }
            }
        });
        retrieveWorker.execute();
	}
}
