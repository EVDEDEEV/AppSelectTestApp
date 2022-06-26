package my.project.appselecttest.network.mmm


import com.google.gson.annotations.SerializedName

data class first(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("has_more")
    val hasMore: Boolean?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("status")
    val status: String?
)