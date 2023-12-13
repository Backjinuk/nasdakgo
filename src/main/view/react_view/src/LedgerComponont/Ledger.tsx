import {LedgerType} from "../TypeList";
import {useEffect, useState} from "react";
import axios from "axios";
export default function Ledger(props : {ledger : LedgerType}){

    const [ledgerItem, setLedgerItem] = useState<LedgerType[]>([]);

    useEffect(() => {

            axios.post("/api/ledger/ledgerItem", JSON.stringify({
                "regDate2" : props.ledger,
                "userNo" : sessionStorage.getItem("userNo")
            }), {
                headers : {
                    "Content-Type" : "application/json"
                }
            }).then(res => {
                console.log(res.data);
                setLedgerItem(res.data);
            })
    }, []);
    return (
        <div className={"itemWarp"}>
            {ledgerItem.map((ledger : LedgerType, index : number) => {
                return(
                    <div className={"ledgerItem"} key={index}>
                        <div>
                            가격 : {ledger.price}
                        </div>
                        <div>
                            입/출금 : {ledger.dw}
                        </div>
                        <div className={"position-date"}>
                            {ledger.regDate}
                        </div>
                    </div>
                )
            })}


        </div>
    )
}