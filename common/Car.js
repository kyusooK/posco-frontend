$(document).ready(function(){
    var OPT = {
        Cols:[
            { Header: "자원 ID", Name: "resourceId", Type: "Text", Width:80, RelWidth:1},
            { Header: "운송 번호", Name: "carrierNo", Type: "Text", Width:80, RelWidth:1},
            { Header: "작업 코드", Name: "worksCode", Type: "Text", Width:80, RelWidth:1},
            { Header: "회사 코드", Name: "companyCode", Type: "Text", Width:80, RelWidth:1},
            { Header: "차량 유형", Name: "carType", Type: "Text", Width:80, RelWidth:1},
            { Header: "차량 모델", Name: "carModel", Type: "Text", Width:80, RelWidth:1},
            { Header: "용도", Name: "usage", Type: "Text", Width:80, RelWidth:1},
            { Header: "연료 플래그", Name: "fuelFlag", Type: "Text", Width:80, RelWidth:1},
            { Header: "부품 회사 코드", Name: "partCompanyCd", Type: "Text", Width:80, RelWidth:1},
            { Header: "소유자 유형 코드", Name: "ownerTypeCode", Type: "Text", Width:80, RelWidth:1},
            { Header: "자산 번호", Name: "assetNumber", Type: "Text", Width:80, RelWidth:1},
            { Header: "조직 이름", Name: "organizationName", Type: "Text", Width:80, RelWidth:1},
            { Header: "취득 금액", Name: "acquisitionAmt", Type: "Text", Width:80, RelWidth:1},
            { Header: "운전자 사원 번호", Name: "driverEmpNo", Type: "Text", Width:80, RelWidth:1},
            { Header: "사용자 이름", Name: "userName", Type: "Text", Width:80, RelWidth:1},
            { Header: "등록 날짜", Name: "registDate", Type: "Text", Width:80, RelWidth:1},
            { Header: "반전 날짜", Name: "reversalDate", Type: "Text", Width:80, RelWidth:1},
            { Header: "관리 번호", Name: "managementNumber", Type: "Text", Width:80, RelWidth:1},
            { Header: "유형", Name: "type", Type: "Text", Width:80, RelWidth:1},
            { Header: "연도 유형", Name: "yearTp", Type: "Text", Width:80, RelWidth:1},
            { Header: "MD 출력 값", Name: "mdOutputValue", Type: "Text", Width:80, RelWidth:1},
            { Header: "LCA 높이", Name: "lcaHeight", Type: "Text", Width:80, RelWidth:1},
            { Header: "수량", Name: "quantity", Type: "Text", Width:80, RelWidth:1},
            { Header: "인원 수", Name: "personCount", Type: "Text", Width:80, RelWidth:1},
            { Header: "표준 값", Name: "standardValue", Type: "Text", Width:80, RelWidth:1},
            { Header: "최대 용량", Name: "maxCapacity", Type: "Text", Width:80, RelWidth:1},
            { Header: "단거리", Name: "shortDistance", Type: "Text", Width:80, RelWidth:1},
            { Header: "차선 거리", Name: "laneDistance", Type: "Text", Width:80, RelWidth:1},
            { Header: "적재 여행 거리", Name: "loadedTravelDistance", Type: "Text", Width:80, RelWidth:1},
            { Header: "검사 날짜", Name: "inspectionDate", Type: "Text", Width:80, RelWidth:1},
            { Header: "설명", Name: "description", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트 날짜", Name: "lastUpdateDate", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트한 사람", Name: "lastUpdatedBy", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성 날짜", Name: "creationDate", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성한 사람", Name: "createdBy", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성 객체 유형", Name: "createdObjectType", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성 객체 ID", Name: "createdObjectId", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성 프로그램 ID", Name: "createdProgramId", Type: "Text", Width:80, RelWidth:1},
            { Header: "생성 타임스탬프", Name: "creationTimestamp", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트 객체 유형", Name: "lastUpdatedObjectType", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트 객체 ID", Name: "lastUpdatedObjectId", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트 프로그램 ID", Name: "lastUpdateProgramId", Type: "Text", Width:80, RelWidth:1},
            { Header: "마지막 업데이트 타임스탬프", Name: "lastUpdateTimestamp", Type: "Text", Width:80, RelWidth:1},
            { Header: "데이터 종료 상태", Name: "dataEndStatus", Type: "Text", Width:80, RelWidth:1},
            { Header: "데이터 종료 객체 유형", Name: "dataEndObjectType", Type: "Text", Width:80, RelWidth:1},
            { Header: "데이터 종료 객체 ID", Name: "dataEndObjectId", Type: "Text", Width:80, RelWidth:1},
            { Header: "데이터 종료 프로그램 ID", Name: "dataEndProgramId", Type: "Text", Width:80, RelWidth:1},
            { Header: "데이터 종료 타임스탬프", Name: "dataEndTimestamp", Type: "Text", Width:80, RelWidth:1},
            { Header: "최대 중량 40", Name: "weight40Max", Type: "Text", Width:80, RelWidth:1},
            { Header: "최대 폭 40", Name: "width40Max", Type: "Text", Width:80, RelWidth:1},
            { Header: "길이 제약 칸", Name: "lengthConstraintKan", Type: "Text", Width:80, RelWidth:1},
            { Header: "사용된 중량", Name: "usedWeight", Type: "Text", Width:80, RelWidth:1},
            { Header: "", Name: "driverIds", Type: "Text", Width:80, RelWidth:1},
            { Header: "", Name: "usage", Type: "Text", Width:80, RelWidth:1},
       ]
   };

   IBSheet.create({
       id:"sheet",
       el:"sheet_DIV",
       options:OPT
   });
});

function retrieve(){
    fetch("http://internal-k8s-ftl-ingress1-eafee7ab24-1743142653.ap-northeast-2.elb.amazonaws.com/l9a990-samplecars/cars/all", {
        method: 'GET',
        headers: {
            "Cache-Control": "no-cache",
            "Pragma": "no-cache",
            "Content-Type": "application/json"
        }
    }).then(res => {
        return res.json();
    }).then(json => {
        sheet.loadSearchData(json)
    }).catch(error => {
        console.error("에러", error);
    });
}

function addData(){
   sheet.addRow();
}

function deleteData(){
    sheet.deleteRow(sheet.getFocusedRow());
}

function save(){
    var rows = sheet.getSaveJson()?.data;

    for(var i=0; i<rows.length;i++){
        switch(rows[i].STATUS){
            case "Added":
                var saveRow = rows[i];
                saveRow["createdObjectType"] =  "C";
                saveRow["createdObjectId"] =  "L9A01001";
                saveRow["createdProgramId"] =  "L9A01001";
                saveRow["creationTimestamp"] =  1643330024000;
                saveRow["lastUpdatedObjectType"] =  "C";
                saveRow["lastUpdatedObjectId"] =  "L9A01001";
                saveRow["lastUpdateProgramId"] =  "L9A01001";
                saveRow["lastUpdateTimestamp"] =  1643330024000;
                $.ajax({
                    url:"http://ap-northeast-2.elb.amazonaws.com/l9a990-samplecars/cars",
                    method:"POST",
                    contentType :"application/json",
                    data:JSON.stringify(saveRow)
                });
                break;
            case "Changed":
                var rowObj = sheet.getRowById(rows[i].id);
                var changedData = JSON.parse(sheet.getChangedData(rowObj))["Changes"][0];
                var nameValueData = {};
                var saveArr = Object.keys(changedData).map((key,idx)=>{
                    return {"name":key , "value": changedData[key]}
                })
                nameValueData["nameValues"] = saveArr;
                var id = rows[i].seq;
                $.ajax({
                    url:`http://ap-northeast-2.elb.amazonaws.com/l9a990-samplecars/cars/${id}`,
                    method:"PUT",
                    contentType :"application/json",
                    data:JSON.stringify(nameValueData),
                });
                break;
            case "Deleted":
                var id = rows[i].seq;
                $.ajax({
                    url:`http://ap-northeast-2.elb.amazonaws.com/l9a990-samplcars/cars/${id}`,
                    method:"DELETE",
                });
                break;
        }     
    }           
}