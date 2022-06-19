package com.example.orgs

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto (val nome : String,
val descricao : String,
val valor : Double,
val image: String? = null) : Parcelable
