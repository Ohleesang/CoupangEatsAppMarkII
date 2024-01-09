package com.example.coupangeatsappmarkii.data

import android.content.Context
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream

object InstanceData {
    val menuList = mutableListOf<Menu>()


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
            val menu = Menu(resId, menuName)
            menuList.add(menu)

        }

    }
}