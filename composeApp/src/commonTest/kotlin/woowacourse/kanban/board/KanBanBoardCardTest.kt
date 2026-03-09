package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanBanBoardCardTest {

    @Test
    fun `제목이 null이면 기본 제목을 노출한다`() = runComposeUiTest {
        setContent {
            Card(title = null, content = "내용", chips = emptyList(), user = "다이노")
        }

        onNodeWithText("제목 없음").assertExists()
    }

    @Test
    fun `내용이 비어있으면 내용 텍스트를 노출하지 않는다`() = runComposeUiTest {
        setContent {
            Card(title = "제목", content = "", chips = emptyList(), user = "다이노")
        }

        onNodeWithText("제목").assertExists()
        onNodeWithText("다이노").assertExists()
        onNodeWithText("카드 내용").assertDoesNotExist()
    }

    @Test
    fun `칩은 최대 다섯개까지만 노출한다`() = runComposeUiTest {
        val chips = listOf("하나", "둘", "셋", "넷", "다섯", "여섯")

        setContent {
            Card(title = "제목", content = "내용", chips = chips, user = "다이노")
        }

        onNodeWithText("하나").assertExists()
        onNodeWithText("둘").assertExists()
        onNodeWithText("셋").assertExists()
        onNodeWithText("넷").assertExists()
        onNodeWithText("다섯").assertExists()
        onNodeWithText("여섯").assertDoesNotExist()
    }
}
