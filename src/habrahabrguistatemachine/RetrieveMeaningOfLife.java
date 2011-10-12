/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package habrahabrguistatemachine;

import javax.swing.SwingWorker;

/**
 *
 * @author __nocach
 */
public class RetrieveMeaningOfLife extends SwingWorker<Integer, Integer>{
    private final MeaningOfLifeAnswerer answerer;

    public RetrieveMeaningOfLife(MeaningOfLifeAnswerer answerer){
        if (answerer == null){
            throw new NullPointerException("prepareProvider can't be null");
        }
        this.answerer = answerer;
        
    }
     
    @Override
    protected Integer doInBackground() throws Exception {
        for(int i = 0; i < 100; i++){
            Thread.sleep(10);
            setProgress(i);
        }
        return answerer.answer();
    }
    
}
