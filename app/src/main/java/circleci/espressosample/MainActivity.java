package circleci.espressosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.goodpatch.feedbacktool.sdk.Balto;
import com.testfairy.TestFairy;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFairy.begin(this, "882114e169dd5278ba361f991e58cb89fa133a9b");
        TestFairy.sendUserFeedback("test add user feedback");
        TestFairy.addCheckpoint("test add checkpoint");
        TestFairy.addEvent("test add event");

        CrashManager.register(this);
        UpdateManager.register(this);

//        DeployGate.install(this.getApplication());
//
//        ((TextView)findViewById(R.id.textAuthorName)).setText(DeployGate.getAuthorUsername());
        ((TextView)findViewById(R.id.textLoginuserName)).setText("");
//
        ((Button)findViewById(R.id.LoginfoButton)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ((TextView)findViewById(R.id.textAuthorName)).setText("Log Info button CLICK!");
            }
        });
        ((Button)findViewById(R.id.LogdebugButton)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ((TextView)findViewById(R.id.textAuthorName)).setText("Log Debug button CLICK!");
            }
        });
//        ((Button)findViewById(R.id.LogVerboseButton)).setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                DeployGate.logVerbose("DeployGate EspressoSample [ Log Verbose ]");
//            }
//        });
//        ((Button)findViewById(R.id.LogwarnButton)).setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                DeployGate.logWarn("DeployGate EspressoSample [ Log Warn ]");
//            }
//        });
//        ((Button)findViewById(R.id.LogerrorButton)).setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                DeployGate.logWarn("DeployGate EspressoSample [ Log Error ]");
//            }
//        });

        Balto.init(this.getApplication());
//        BaltoApi.getInstance().postFeedback(String apiToken, String gitHubToken, String buildId, BaltoPostFeedbackRequest baltoPostFeedbackRequest)
    }
}
