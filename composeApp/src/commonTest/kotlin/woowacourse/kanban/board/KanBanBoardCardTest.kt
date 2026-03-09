package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanBanBoardCardTest {
    // 정상 글자 수와 갯수를 가진 칩 리스트
    val normalChips: List<String> = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임")

    // 정상 갯수이지만 정상 글자 수를 초과한 칩 리스트
    val longChips: List<String> = listOf("글자수가 넘어가는 긴 태그1", "글자수가 넘어가는 긴 태그2", "글자수가 넘어가는 긴 태그3", "글자수가 넘어가는 긴 태그4", "글자수가 넘어가는 긴 태그5")

    // 정상 글자 수 이지만 정상 갯수를 초과한 칩 리스트
    val overChips: List<String> = listOf("하나", "둘", "셋", "넷", "다섯", "여섯")

    // 제목
    @Test
    fun `제목 텍스트가 비어있으면 제목없음 텍스트를 기본으로 노출한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = normalChips,
                assignee = "다이노",
            )
        }

        onNodeWithText("제목없음").assertExists()
    }

    @Test
    fun `유효한 제목이 입력되면 그대로 노출시킨다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = normalChips,
                assignee = "다이노",
            )
        }

        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
    }

    @Test
    fun `너무 긴 제목은 한줄까지만 노출시키고 말줄임표로 처리한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "너무너무너무 긴 제목은 한 줄까지만 노출하고 말줄임표로 처리합니다",
                description = "설명",
                chips = normalChips,
                assignee = "다이노",
            )
        }
    }

    // 설명
    @Test
    fun `설명이 비어있으면 설명 텍스트를 노출하지 않는다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "",
                chips = normalChips,
                assignee = "다이노",
            )
        }

        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("다이노").assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.").assertDoesNotExist()
    }

    @Test
    fun `너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
                chips = normalChips,
                assignee = "다이노",
            )
        }
    }

    // 칩(1개)
    @Test
    fun `칩의 글자수는 5글자로 제한한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = longChips,
                assignee = "다이노",
            )
        }
    }

    // 칩(여러 개 - 5개 제한)
    @Test
    fun `칩은 최대 다섯개까지만 노출한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = overChips,
                assignee = "다이노",
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
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = overChips,
                assignee = "",
            )
        }

        onNodeWithText("담당자없음").assertExists()
    }

    @Test
    fun `너무 긴 담당자는 한 줄까지만 노출하고 말줄임표로 처리한다`() = runComposeUiTest {
        setContent {
            Card(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                chips = normalChips,
                assignee = "너무너무 긴 담당자도 한줄까지만 노출하고 말줄임표로 처리합니다",
            )
        }
    }
}
