package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CardUnitTest {

    // 제목
    @Test
    fun `제목이 null 이면 제목없음을 띄운다`() {
        assertEquals("제목없음", resolveCardTitle(null))
    }

    @Test
    fun `제목이 공백이면 제목없음을 띄운다`() {
        assertEquals("제목없음", resolveCardTitle("   "))
    }

    @Test
    fun `긴 제목도 resolve 단계에서는 그대로 반환한다`() {
        val longTitle = "너무너무 긴 제목은 한 줄까지만 노출하고 말줄임표로 처리합니다"

        assertEquals(longTitle, resolveCardTitle(longTitle))
    }

    @Test
    fun `유효한 제목은 그대로 반환한다`() {
        assertEquals("칸반보드 카드 제목", resolveCardTitle("칸반보드 카드 제목"))
    }


    // 설명
    @Test
    fun `설명이 null 이면 노출하지 않는다`() {
        assertNull(resolveCardDescription(null))
    }

    @Test
    fun `설명이 공백이면 노출하지 않는다`() {
        assertNull(resolveCardDescription(" "))
    }

    @Test
    fun `유효한 설명은 그대로 반환한다`() {
        assertEquals("상세 설명", resolveCardDescription("상세 설명"))
    }

    // 칩
    @Test
    fun `칩 텍스트가 null이면 노출하지 않는다`() {
        assertNull(resolveCardChip(null))
    }

    @Test
    fun `칩 텍스트가 공백이면 노출하지 않는다`() {
        assertNull(resolveCardChip(" "))
    }

    @Test
    fun `칩 텍스트는 다섯 글자까지만 반환한다`() {
        assertEquals("abcde", resolveCardChip("abcdefghi"))
    }

    @Test
    fun `칩은 최대 다섯개까지만 반환한다`() {
        val chips = listOf("1", "2", "3", "4", "5", "6")

        assertEquals(listOf("1", "2", "3", "4", "5"), resolveVisibleChips(chips))
    }

    // 담당자
    @Test
    fun `담당자가 null이면 담당자없음을 반환한다`() {
        assertEquals("담당자없음", resolveCardAssignee(null))
    }

    @Test
    fun `담당자가 공백이면 담당자없음을 반환한다`() {
        assertEquals("담당자없음", resolveCardAssignee(" "))
    }

    @Test
    fun `긴 담당자 이름도 resolve 단계에서는 그대로 반환한다`() {
        val longAssignee = "너무너무너무 긴 담당자도 한 줄까지만 노출하고 말줄임표로 처리합니다"

        assertEquals(longAssignee, resolveCardAssignee(longAssignee))
    }

    @Test
    fun `유효한 담당자 이름은 그대로 반환한다`() {
        assertEquals("유효한 담당자 이름", resolveCardAssignee("유효한 담당자 이름"))
    }

}
