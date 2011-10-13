package habrahabrguistatemachine.mvc;

public interface MvcAnswerDialogModelListener {
	public void onPreparingStarted();
	public void onPreparedSuccess();
	public void onPreparedFailure();
	public void onSearchingProgress(int progress);
	public void onSearchingStarted();
	public void onSearchCompleteSuccess(Integer answer);
	public void onSearchCompleteFailure();
}
