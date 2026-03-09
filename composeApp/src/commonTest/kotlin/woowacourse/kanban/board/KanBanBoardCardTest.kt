package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.KanBanBoardCardTest.AssigneeFixture.LONG_ASSIGNEE
import woowacourse.kanban.board.KanBanBoardCardTest.AssigneeFixture.NORMAL_ASSIGNEE
import woowacourse.kanban.board.KanBanBoardCardTest.ChipsFixture.LONG_CHIPS
import woowacourse.kanban.board.KanBanBoardCardTest.ChipsFixture.NORMAL_CHIPS
import woowacourse.kanban.board.KanBanBoardCardTest.ChipsFixture.OVER_CHIPS
import woowacourse.kanban.board.KanBanBoardCardTest.DescriptionFixture.NORMAL_DESCRIPTION
import woowacourse.kanban.board.KanBanBoardCardTest.TitleFixture.LONG_TITLE
import woowacourse.kanban.board.KanBanBoardCardTest.TitleFixture.NORMAL_TITLE
import woowacourse.kanban.board.KanBanBoardCardTest.DescriptionFixture.LONG_DESCRIPTION

import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanBanBoardCardTest {
    object TitleFixture {
        // 정상 글자수 내의 글자수의 제목
        val NORMAL_TITLE = "LazyColumn 컴포넌트 구현"

        // 정상 글자수를 벗어난 글자수의 제목
        val LONG_TITLE = "너무너무너무 긴 제목은 한 줄까지만 노출하고 말줄임표로 처리합니다"
    }

    object DescriptionFixture {
        // 정상 글자수 내의 설명
        val NORMAL_DESCRIPTION = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."

        // 정상 글자수를 벗어난 설명
        val LONG_DESCRIPTION = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다."
    }

    object ChipsFixture {
        // 정상 글자 수와 갯수를 가진 칩 리스트
        val NORMAL_CHIPS = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임")

        // 정상 갯수이지만 정상 글자 수를 초과한 칩 리스트
        val LONG_CHIPS = listOf("글자수가 넘어가는 긴 태그1", "글자수가 넘어가는 긴 태그2")

        // 정상 글자 수 이지만 정상 갯수를 초과한 칩 리스트
        val OVER_CHIPS = listOf("하나", "둘", "셋", "넷", "다섯", "여섯")
    }

    object AssigneeFixture {
        // 정상 글자수 내의 담당자
        val NORMAL_ASSIGNEE = "다이노"

        // 정상 글자수를 벗어난 담당자
        val LONG_ASSIGNEE = "너무너무 긴 담당자도 한줄까지만 노출하고 말줄임표로 처리합니다"
    }

    // 제목
    @Test
    fun `제목 텍스트가 비어있으면 제목없음 텍스트를 기본으로 노출한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "",
                description = NORMAL_DESCRIPTION,
                chips = NORMAL_CHIPS,
                assignee = NORMAL_ASSIGNEE,
            )
        }

        onNodeWithText("제목없음").assertExists()
    }

    @Test
    fun `유효한 제목이 입력되면 그대로 노출시킨다`() = runComposeUiTest {
        setContent {
            Card(
                title = NORMAL_TITLE,
                description = NORMAL_DESCRIPTION,
                chips = NORMAL_CHIPS,
                assignee = NORMAL_ASSIGNEE,
            )
        }

        onNodeWithText(NORMAL_TITLE).assertExists()
    }

    // 설명
    @Test
    fun `설명이 비어있으면 설명 텍스트를 노출하지 않는다`() = runComposeUiTest {
        setContent {
            Card(
                title = NORMAL_TITLE,
                description = "",
                chips = NORMAL_CHIPS,
                assignee = NORMAL_ASSIGNEE,
            )
        }

        onNodeWithText(NORMAL_TITLE).assertExists()
        onNodeWithText(NORMAL_ASSIGNEE).assertExists()
        onNodeWithText(LONG_DESCRIPTION).assertDoesNotExist()
    }

    // 칩(여러 개 - 5개 제한)
    @Test
    fun `칩은 최대 다섯개까지만 노출한다`() = runComposeUiTest {
        setContent {
            Card(
                title = NORMAL_TITLE,
                description = NORMAL_DESCRIPTION,
                chips = OVER_CHIPS,
                assignee = NORMAL_ASSIGNEE,
            )
        }

        onNodeWithText("하나").assertExists()
        onNodeWithText("둘").assertExists()
        onNodeWithText("셋").assertExists()
        onNodeWithText("넷").assertExists()
        onNodeWithText("다섯").assertExists()
        onNodeWithText("여섯").assertDoesNotExist()
    }

    // 담당자
    @Test
    fun `담당자 텍스트가 비어있으면 담당자없음 텍스트를 기본으로 노출한다`() = runComposeUiTest {
        setContent {
            Card(
                title = NORMAL_TITLE,
                description = NORMAL_DESCRIPTION,
                chips = OVER_CHIPS,
                assignee = "",
            )
        }

        onNodeWithText("담당자없음").assertExists()
    }
}
