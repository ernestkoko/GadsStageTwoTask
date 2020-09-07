package ernestkoko.gads.gadsstagetwotask.models

data class LearnerLeadersModel(
 var name: String? = "",
 var hours: Int,
 var country: String,
 var badgeUrl: String
)

data class SkillIqLeadersModel(
 var name: String? = "",
 var score: Int? = 0,
 var country: String? = "",
 var badgeUrl: String? = ""
)