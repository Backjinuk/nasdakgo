import {CategoryType} from "../TypeList";

export default function CreateCategory({categoryList} : any){

    const css : any ={
        height: "150px",
        display: "flex",
        alignItems: "center",
        justifyContent: "right",
        marginRight: "30%"
    }


    return (
        <div>
            <div style={css}>
                <input type={"button"} className={"btn btn-bd-primary"} value={"카테고리"}
                       data-bs-toggle="modal"
                       data-bs-target="#updateCategory"/>
            </div>
            <form></form>
            <div className="modal fade " id="updateCategory" data-bs-keyboard="false"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true" tabIndex={-1}>
                <div className="modal-dialog modal-dialog-centered">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id="staticBackdropLabel">카테고리</h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <form name={"addLedger"}>
                            <div className="modal-body">

                                <div className="mb-3">
                                    <div className="form-floating">

                                        <select name={"category_no"} className="form-select" id="floatingSelectGrid">
                                            <option>선택</option>
                                            {categoryList.map((category: CategoryType, index: number) => {
                                                return (
                                                    <option key={index}
                                                            value={category.categoryNo}>{category.content}</option>
                                                )
                                            })}
                                        </select>

                                        <label htmlFor="floatingSelectGrid">카테고리를 선택해 주세요</label>
                                    </div>
                                </div>
                                </div>
                                <div className="form-floating mb-3">
                                    <input type="text" name={"comment"} className="form-control" id="floatingSpassword"
                                           placeholder="내용을 입력해주세요"/>
                                    <label htmlFor="floatingSpassword">내용</label>
                                </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal"> 취소
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}