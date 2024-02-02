package com.example.coupangeatsappmarkii.data

import android.content.Context
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream

sealed class ListItem {
    data class MenuList(val menus: List<Menu>) : ListItem()
    data class RestList(val rests: List<Rest>) : ListItem()
    data class Title(val name : String) :ListItem()
    data class Menu(val imgRes: Int, val name: String) : ListItem()
    data class Rest(
        val name: String,
        val time: String,
        val score: String,
        val distance: String,
        val mainImgRes: Int,
        val subImgRes1: Int,
        val subImgRes2: Int,
    ) : ListItem()

    data object Search : ListItem()

}

object DummyData {
    var menuList = mutableListOf<ListItem.Menu>()
    var restList = mutableListOf<ListItem.Rest>()

    //xlsx 파일 데이터 저장
    private fun setDummyData(context: Context, fileName: String): MutableList<List<String>> {

        val dataArray = mutableListOf<List<String>>()

        try {
            //A. assets 폴더에 저장된 Excel 파일 열기
            val inputStream: InputStream = context.assets.open(fileName)
            val workbook = XSSFWorkbook(inputStream)
            val sheet = workbook.getSheetAt(0)


            //B. 해당 데이터를 읽어들인후 값을 저장
            //각 행을 처리
            for (row: Row in sheet) {
                val rowData = mutableListOf<String>()

                // 셀의 개수에 따라 데이터를 배열에 추가
                for (cell in row) {
                    //셀이 비어있으면 무시
                    if (cell.cellType == CellType.BLANK) continue
                    rowData.add(cell.toString())
                }
                if (rowData.isNotEmpty()) dataArray.add(rowData)

            }
            //C .파일 닫기
            inputStream.close()

            // 설명부분 제거
            dataArray.removeFirst()

        } catch (_: Exception) {
        }
        return dataArray
    }


    //메뉴 인스턴스 저장
    fun setDummyDataMenu(context: Context, fileName: String) {
        val data = setDummyData(context, fileName)
        data.forEach { row ->
            //1. 이미지 리소스 파일을 찾아서 해당되는 값 찾기
            val resId = context.resources.getIdentifier(row[0], "drawable", context.packageName)
            //2. 메뉴 이름
            val menuName = row[1]

            // 인스턴스 생성 이후 값넣기
            val menu = ListItem.Menu(resId, menuName)
            menuList.add(menu)

        }

    }

    fun setDummyDataRest(context: Context, fileName: String) {
        val data = setDummyData(context, fileName)
        data.forEach { row ->
            // 1. 가게 이름 ,2. 배달 시간 3.별점(리뷰수) 4. 배달 거리
            val restName = row[0]
            val time = row[1] +"분"
            val score = row[2]
            val distance = row[3] +" km"

            // 2. 이미지 소스
            val mainImgResId =
                context.resources.getIdentifier(row[4], "drawable", context.packageName)
            val subImgResId1 =
                context.resources.getIdentifier(row[5], "drawable", context.packageName)
            val subImgResId2 =
                context.resources.getIdentifier(row[6], "drawable", context.packageName)

            val rest =
                ListItem.Rest(
                    restName,
                    time,
                    score,
                    distance,
                    mainImgResId,
                    subImgResId1,
                    subImgResId2
                )
            restList.add(rest)

        }
    }
}