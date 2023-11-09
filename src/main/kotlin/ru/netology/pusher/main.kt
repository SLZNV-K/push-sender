package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val likeMessage = Message.builder()
        .putData("action", "LIKE")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
        )
        .setToken(token)
        .build()

//    val postMessage = Message.builder()
//        .putData("action", "POST")
//        .putData(
//            "content", """{
//          "userName": "Vasiliy",
//          "content": "Alice began dreaming after hunting about ravens and was as it sounds uncommon nonsense.Alice took no use in reply.Please your tea; it is not pleasing them! When the young man said, by the Knave did not here anymore simply--Never imagine yourself to get her side. The rabbit-hole under the same thing she had all joined the Cat went on with this time, while the very civil of the Duchess sang the edge with a shrill, passionate voice. Back to open air. Even the general clapping of my poor."
//        }""".trimIndent()
//        )
//        .setToken(token)
//        .build()

    FirebaseMessaging.getInstance().send(likeMessage)
//    FirebaseMessaging.getInstance().send(postMessage)
}
