package com.primefootball.apigateway.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.common.collect.Lists
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import java.io.IOException

@Configuration
class FirebaseConfig {
//
    @Throws(IOException::class)
    fun firebaseSetup(){
        val credentials: GoogleCredentials = GoogleCredentials.fromStream(FileInputStream("../../resources/serviceAccountKey.json"))
            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"))

        val options = FirebaseOptions.builder()
            .setCredentials(credentials)
            .setDatabaseUrl("https://prime-football-default-rtdb.europe-west1.firebasedatabase.app/")
            .build()

        FirebaseApp.initializeApp(options)
    }
}