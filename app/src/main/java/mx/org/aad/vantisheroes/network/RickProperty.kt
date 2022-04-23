package mx.org.aad.vantisheroes.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RickProperty
    (
        val id: String,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        @Json(name = "image") val image: String
    ) : Parcelable {
}
