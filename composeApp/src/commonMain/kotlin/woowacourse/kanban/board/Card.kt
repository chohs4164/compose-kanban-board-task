package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.Theme.Gray100
import woowacourse.kanban.board.Theme.Gray200
import woowacourse.kanban.board.Theme.Gray500
import woowacourse.kanban.board.Theme.Gray600
import woowacourse.kanban.board.Theme.Gray700
import woowacourse.kanban.board.Theme.Gray900


private const val DEFAULT_TITLE= "제목없음"
private const val MAX_TITLE_LENGTH = 20 // 말줄임표로 표시되는 기준을 글자수 20으로 정의하겠습니다.
@Composable
fun Card(title: String = "제목없음", content: String = "", chips: List<String> = emptyList(), user: String = "알수없음") {
    Column(
        modifier = Modifier
            .width(286.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Gray200)
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Title(title)
        if (content.isNotBlank()) Content(content)
        if (chips.isNotEmpty()) {
            Chips(chips)
        }
        User(name = user)
    }
}

@Composable
fun Title(title: String?) {
    val displayTitle = title?.takeIf { it.isNotBlank() } ?: "제목 없음"
    Text(
        text = displayTitle,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = Gray900,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Content(content: String?) {
    val displayContent = content?.takeIf { it.isNotBlank() } ?: ""
    Text(
        text = displayContent,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Gray600,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Chip(text: String) {
    Text(
        text = text.take(5),
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = Gray700,
        modifier = Modifier
            .clip(CircleShape)
            .background(color = Gray100)
            .padding(horizontal = 8.dp, vertical = 4.dp),
    )
}

@Composable
fun Chips(chips: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        chips.take(5).forEach { Chip(it) }
    }
}


@Composable
fun User(name: String) {

    HorizontalDivider(color = Gray200, thickness = 1.dp)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color = Color.White)
                .border(width = 2.dp, color = Gray500, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "profile image",
                tint = Gray500,
                modifier = Modifier
                    .clip(CircleShape)
                    .requiredSize(size = 33.dp),
            )
        }
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Gray700,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
@Preview(
    heightDp = 1000,
)
fun CardPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            chips = listOf("컴포넌트", "성능"),
            user = "다이노",
        )
        Card(
            title = "LazyColumn 컴포넌트 구현",
            chips = listOf("컴포넌트", "성능"),
            user = "다이노",
        )
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            user = "다이노",
        )
        Card(
            title = "LazyColumn 컴포넌트 구현",
            user = "다이노",
        )

        Card(
            title = "너무너무 긴 제목은 한 줄까지만 노출하고 말줄임표로 처리합니다.",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            chips = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            user = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄",
        )
    }
}

// 단위 테스트용
// 제목
internal fun resolveCardTitle(title: String?): String {
    val normalizedTitle = title?.trim()

    return when {
        normalizedTitle.isNullOrEmpty() -> DEFAULT_TITLE
        normalizedTitle.length > MAX_TITLE_LENGTH -> normalizedTitle.take(MAX_TITLE_LENGTH)
        else -> normalizedTitle
    }
}

// 내용
internal fun resolveCardContent(content: String?): String {
    val
}
// 칩(1개)

internal fun resolveCardChip(chip: String?): String =
    chip.takeIf { it.isNotBlank() } ?: ""

internal fun
// 사용자