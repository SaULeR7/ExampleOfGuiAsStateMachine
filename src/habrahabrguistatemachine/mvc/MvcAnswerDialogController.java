package habrahabrguistatemachine.mvc;


/**
 * Controller for the dialog. Has single method doButtonClicked() because it's the only
 * input event we are interested in.
 * @author __nocach
 *
 */
public class MvcAnswerDialogController {
	private MvcAnswerDialogModel model;
	public MvcAnswerDialogController(MvcAnswerDialogModel model){
		if (model == null){
			throw new NullPointerException("model can't be null");
		}
		this.model = model;
		model.prepare();
	}
	
	public void doButtonClicked(){
		MvcAnswerDialogController.this.model.answerTheQuestion();
	}
}
