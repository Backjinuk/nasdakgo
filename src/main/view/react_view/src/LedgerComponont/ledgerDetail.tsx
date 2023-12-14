import {CategoryType, LedgerType} from "../TypeList";
import axios from "axios";
import {useState} from "react";
import e from "express";

export default function  LedgerDetail({categoryList, ledger} : {categoryList : CategoryType[], ledger : LedgerType}){

    const [fileManagerNo, setFileManagerNo] = useState(ledger.fileManagerNo);
    const [price, setPrice] = useState(ledger.price);
    const [dw, setDw] = useState(ledger.dw);
    const [location, setLocation] = useState(ledger.location);
    const [comment, setComment] = useState(ledger.comment);
    const [categoryNo, setCategoryNo] = useState(ledger.categoryDto.categoryNo);

    function ledgerUpdate(fileManagerNo : number){
        var queryString = $("from[name=updateLedger]").serializeArray();

        console.log(queryString);

        axios.post("api/ledger/ledgerItemUpdate", JSON.stringify(fileManagerNo),{
            headers : {
                "Content-Type" : "application/json"
            }
        }).then(res => {
            console.log(res.data);
        })
    }

    return (
        <div className="modal fade " id="ledgerDetail" data-bs-keyboard="false"
             aria-labelledby="staticBackdropLabel" aria-hidden="true" tabIndex={-1}>
            <div className="modal-dialog modal-dialog-centered">
                <div className="modal-content">
                    <div className="modal-header">
                        <h1 className="modal-title fs-5" id="staticBackdropLabel">글쓰기</h1>
                        <button type="button" className="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <form name={"updateLedger"}>
                        <div className="modal-body">

                            <div className="mb-3">
                                <div className="form-floating">

                                    <select name="category_no" className="form-select" id="floatingSelectGrid"  defaultValue={ledger.categoryDto.categoryNo}>
                                        <option value="">선택</option>
                                        {categoryList.map((category: CategoryType, index: number) => (
                                            <option key={index} value={category.categoryNo}>{category.content}</option>
                                        ))}
                                    </select>

                                    <label htmlFor="floatingSelectGrid">카테고리를 선택해 주세요</label>
                                </div>
                            </div>

                            <div className="form-floating mb-3">
                                <input type="text" name={"dw"} className="form-control" id="dw"
                                       placeholder="입/출금을 입력해주세요" value={dw} onChange={(e) => {
                                    setDw(Number(e.target.value))
                                }}/>
                                <label htmlFor="dw">입/출금</label>
                            </div>

                            <div className="form-floating mb-3">
                                <input type="text" name={"price"} className="form-control" id="price" value={price} onChange={(e) => {setPrice(Number(e.target.value))}}
                                       placeholder="가격을 입력해주세요"/>
                                <label htmlFor="price">가격</label>
                            </div>

                            <div className="form-floating mb-3">
                                <input type="text" name={"location"} className="form-control" id="location" value={location} onChange={(e) => {setLocation(e.target.value)}}
                                       placeholder="지역을 입력해주세요"/>
                                <label htmlFor="location">지역</label>
                            </div>

                            <div className="form-floating mb-3">
                                <input type="text" name={"comment"} className="form-control" id="floatingSpassword" value={comment} onChange={e => {setComment(e.target.value)}}
                                       placeholder="내용을 입력해주세요"/>
                                <label htmlFor="floatingSpassword">내용</label>
                            </div>

                            <div className="input-group mb-3">
                                <input type="file" multiple className="form-control uploadFile" id="file"/>
                                <label className="input-group-text" htmlFor="file">Upload</label>
                            </div>

                        </div>
                        <div className="modal-footer">
                            {/*onClick={() => addLedger()}*/}

                            <button type="button" className="btn btn-primary" onClick={() => ledgerUpdate(ledger.fileManagerNo)}>수정</button>
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal"> 취소
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    )
}