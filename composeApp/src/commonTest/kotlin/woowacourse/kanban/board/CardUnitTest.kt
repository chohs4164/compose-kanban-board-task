package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CardUnitTest {

    // 제목
    @Test
    fun `제목이 null 이면 "제목없음"을 띄운다`() {
        assertEquals("제목없음", resolveCardTitle(null))
    }

    @Test
    fun `제목이 공백이면 "제목없음"을 띄운다`() {
        assertEquals("제목없음", resolveCardTitle("   "))
    }

    @Test
    fun `제목 길이가 20자 이상으로 길어지면 말줄임표로 생략한다`() {
        val longTitle = "너무너무 긴 제목은 한 줄까지만 노출하고 말줄임표로 처리합니다"

        assertEquals("너무너무 긴 제목은 한 줄까지만 노출", resolveCardTitle(longTitle))
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

    // 사용자이름
    @Test
    fun `사용자 이름이 null이면 "사용자이름없음"을 띄운다`() {
        assertEquals("사용자이름없음", resolveCardUser(null))
    }

    @Test
    fun `사용자 이름이 공백이면 "사용자이름없음"을 띄운다`() {
        assertEquals("사용자이름없음", resolveCardUser(" "))
    }

    @Test
    fun `사용자 이름 길이가 17자를 넘어가면 말줄임표로 생략한다`() {
        assertEquals("너무너무너무 긴 담당자도 한 줄", resolveCardUser("너무너무너무 긴 담당자도 한 줄까지만 노출하고 말줄임표로 처리합니다"))
    }

    @Test
    fun `유효한 사용자 이름은 그대로 반환한다`() {
        assertEquals("유효한 사용자 이름", resolveCardUser("유효한 사용자 이름"))
    }

}
