package grownapps.casamientofloryagus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        //loginButton.setReadPermissions("email");

    // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                request();
        }

        @Override
        public void onCancel() {
            // App code
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
        }
    });
}
    private void request() {
        GraphRequest request = new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        JSONObject jsonObject = response.getJSONObject();

                        try {
                            String name = jsonObject.getString("name");
                            JSONObject jsonObjectPicture = jsonObject.getJSONObject("picture");
                            JSONObject jsonObjectData = jsonObjectPicture.getJSONObject("data");
                            String imageUrl = jsonObjectData.getString("url");
                            //LE AGARRÉ EL NAME Y LA IMAGEN. DESPUES LA PUEDO MANDAR A LA LISTA DE
                            //INVITADOS NO?

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,picture");
        request.setParameters(parameters);
        request.executeAsync();

        Intent intent = new Intent(this,MainActivity.class);
        //fijate si queres meterle algo al intent, como un bundle, o si con esto alcanza.
        startActivity(intent);

        //tambien creo que tenes que cambiar el launcher una vez que el login es efectivo.
        //o eso ya esta? se guardan los datos?
        //a session le tengo que pedir get active session, para saber si ya esta logueado
        //te manda a la main activity, no lalogin. eso se hace aca al principio de toddo, es un if.
        //el launcher es activity login facebook, no el main, eso esta bien.
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


//    METODO PARA EL SHARE.
//    EN EL ONCREATE TENES QUE PONERLE
// shareButton = (ShareButton)findViewById(R.id.fb_share_button);

    // Other app specific specialization

    //Aca configuramos el share button
    //configureShareButton();

//    if(AccessToken.getCurrentAccessToken() != null){
//        request();
//    }

// Y ESTE METODO MAS ABAJO

// public void configureShareButton(){
//        //Aca seteamos el contenido que queremos mostrar
//        ShareLinkContent linkContent = new ShareLinkContent.Builder()
//                .setContentTitle("Hello Facebook")
//                .setContentDescription(
//                        "The 'Hello Facebook' sample  showcases simple Facebook integration")
//                .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
//                .setImageUrl(Uri.parse("http://blog.storyful.com/wp-content/uploads/sites/5/2016/04/Facebook-create.png"))
//                .build();
//
//        //Aca asociamos el contenido que queremos mostrar al share button
//        shareButton.setShareContent(linkContent);

    }



