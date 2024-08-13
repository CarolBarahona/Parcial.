package com.mycompany.mercado;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author barah
 */
public class ConexionFirebase {

    public static Firestore db;

    public static void conectarFirabase() {

        try {
            FileInputStream sa = new FileInputStream("mercado.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(sa))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Exito al conectar");
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }

    }
    
}

