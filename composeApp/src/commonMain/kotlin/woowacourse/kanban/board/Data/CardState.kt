package woowacourse.kanban.board.Data

data class CardState(
    val title: String,
    val description: String,
    val chips: List<String>,
    val assignee: String,
)
