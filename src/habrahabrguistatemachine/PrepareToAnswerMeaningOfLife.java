/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package habrahabrguistatemachine;

import habrahabrguistatemachine.domain.MeaningOfLifeAnswerer;

import javax.swing.SwingWorker;

/**
 * worker that prepares MeaningOfLifeAnswerer
 * @author __nocach
 */
public class PrepareToAnswerMeaningOfLife extends SwingWorker<MeaningOfLifeAnswerer, Void>{
    @Override
    protected MeaningOfLifeAnswerer doInBackground() throws Exception {
        Thread.sleep(1500);
        return new MeaningOfLifeAnswerer();
    }
}
