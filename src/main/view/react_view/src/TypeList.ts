export interface CategoryType{
    collectionNo : number ,
    categoryNo : number ,
    userdDto : UsersType,
    content : string ,
    delYn : string
}

export interface UsersType{
    userNo : number ,
    userId : string ,
    passowrd : string ,
    eamil : string ,
    phone : string ,
    regDate :  string
}

export interface LedgerType{
    fileManagerNo : number ,
    userDto : UsersType ,
    CategoryDto : CategoryType ,
    price : number ,
    dw : number ,
    location : string,
    comment : string

}
