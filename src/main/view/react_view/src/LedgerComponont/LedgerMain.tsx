import CreateLeger from "./CreateLeger"
import Ledger from "./Ledger"
import axios from "axios";
import {useEffect, useState} from "react";
import {LedgerType} from "../TypeList";
import "./Ledger.css";




interface LedgerProps {
    ledger: LedgerType;
}

export default function LedgerMain(){

    const [ledgerList, setLedgerList] = useState<LedgerType[]>([] );

    useEffect(() => {
        axios.post("/api/ledger/LedgerList", JSON.stringify({
            userNo: sessionStorage.getItem("userNo")

        }),{
            headers : {
                "Content-Type" : "application/json"
            }
        }).then(res => {
            console.log(res.data);
            setLedgerList(res.data);
        })

    }, []);


    return(
        <div>
            <CreateLeger />
            <div className={"warp"}>
                {ledgerList.map((ledger: LedgerType, index: number) => (
                    <div className="card shadow-lg" key={index}>
                    <Ledger ledger={ledger} />
                    </div>
                ))}
            </div>
        </div>
    )
}