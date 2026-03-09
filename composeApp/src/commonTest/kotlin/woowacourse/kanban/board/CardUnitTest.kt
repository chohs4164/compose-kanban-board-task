package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CardUnitTest {

    // 제목
    @Test
    fun `제목이 null 이면 "제목없음"을 띄운다`() {
        assertEquals("제목 없음", resolveCardTitle(null))
    }

    @Test
    fun `제목이 공백이면 "제목없음"을 띄운다`() {
        assertEquals("제목 없음", resolveCardTitle("   "))
    }

    @Test
    fun `유효한 제목은 그대로 반환한다`() {
        assertEquals("칸반보드 카드 제목", resolveCardTitle("칸반보드 카드 제목"))
    }

    // 내용
    @Test
    fun `내용이 null 이면 노출하지 않는다`() {
        assertNull(resolveCardContent(null))
    }

    @Test
    fun `내용이 공백이면 노출하지 않는다`() {
        assertNull(resolveCardContent(" "))
    }

    @Test
    fun `유효한 내용은 그대로 반환한다`() {
        assertEquals("상세 내용", resolveCardContent("상세 내용"))
    }

    // 칩
    @Test
    fun `칩은 최대 다섯개까지만 반환한다`() {
        val chips = listOf("1", "2", "3", "4", "5", "6")

        assertEquals(listOf("1", "2", "3", "4", "5"), resolveVisibleChips(chips))
    }

    @Test
    fun `칩 텍스트는 다섯 글자까지만 반환한다`() {
        assertEquals("abcde", resolveChipText("abcdefghi"))
    }
}
