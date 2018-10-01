package backgroundcalculator;

import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class BackgroundCalculator extends SwingWorker< Long, Object> {

    private final int n; // Fibonacci number to calculate
    private final JLabel resultJLabel; // JLabel to display the result

    // constructor
    public BackgroundCalculator(int number, JLabel label) {
        n = number;
        resultJLabel = label;
    } // end BackgroundCalculator constructor
    // long-running code to be run in a worker thread

    @Override
    public Long doInBackground() throws InterruptedException {
        return fibonacci(n);
    } // end method doInBackground

    // code to run on the event dispatch thread when doInBackground returns
    protected void done() {
        try {
            resultJLabel.setText(get().toString());
        } // end try
        catch (InterruptedException ex) {
            resultJLabel.setText("Interrupted while waiting for results.");
        } // end catch
        catch (ExecutionException ex) {
            resultJLabel.setText(
                    "Error encountered while performing calculation.");
        } // end catch
    } // end method done

    // recursive method fibonacci; calculates nth Fibonacci number
    public long fibonacci(long number) throws InterruptedException {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    } // end method fibonacci
} // end class BackgroundCalculator
