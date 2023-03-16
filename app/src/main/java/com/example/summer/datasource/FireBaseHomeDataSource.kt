package com.example.summer.datasource

import android.net.Uri
import com.example.summer.data.dto.HomeDto
import com.example.summer.util.COLLECTION_HOMES
import com.example.summer.util.COLLECTION_ROOT
import com.example.summer.util.DOCUMENT_HOME
import com.example.summer.util.STORAGE_IMAGES
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID
import kotlin.coroutines.suspendCoroutine

class FireBaseHomeDataSource(
    private val firebaseFirestore: FirebaseFirestore,
    private val firebaseStorage: FirebaseStorage
) : HomeDataSource {

    //Referencias de acesso a dados no banco do firebase, trabalhando com coleções e documentos.
    //data/home/homes/timestamp/home

    private val documentReference = firebaseFirestore
        .document("$COLLECTION_ROOT/$DOCUMENT_HOME/")

    private val storagereference = firebaseStorage.reference

    override suspend fun getHomes(): List<HomeDto> {
        return suspendCoroutine { continuation ->
            val homesReference = documentReference.collection(COLLECTION_HOMES)
            homesReference.get().addOnSuccessListener { documents ->

                val homes = mutableListOf<HomeDto>()
                for (document in documents) {
                    document.toObject(HomeDto::class.java).run {
                        homes.add(this)
                    }
                }
                continuation.resumeWith(Result.success(homes))
            }
                .addOnFailureListener { exception ->
                    continuation.resumeWith(Result.failure(exception))
                }
        }
    }



    override suspend fun uploadHomeImages(listImageUri: List<Uri>): String {
        return suspendCoroutine { continuation ->
            val randoKey = UUID.randomUUID()
            // ESTRUTURA DE UPLOAD DE IMAGENS = IMAGES/HOME/RANDOMKEY
            val childReference = storagereference.child(
                "$STORAGE_IMAGES/$DOCUMENT_HOME/$randoKey"
            )
            listImageUri.map { image ->
                childReference.putFile(image)
                    .addOnSuccessListener { taskSnapshot ->
                        taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                            val path = uri.toString()
                            continuation.resumeWith(Result.success(path))
                        }

                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWith(Result.failure(exception))

                    }
            }

        }

    }

    override suspend fun createHome(home: HomeDto): HomeDto {
        return suspendCoroutine { continuation ->
            documentReference
                .collection(COLLECTION_HOMES)
                .document(System.currentTimeMillis().toString())
                .set(home)
                .addOnSuccessListener {
                    continuation.resumeWith(Result.success(home))
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWith(Result.failure(exception))
                }

        }
    }
}