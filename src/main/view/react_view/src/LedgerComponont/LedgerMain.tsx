import CreateLeger from "./CreateLeger"
import Ledger from "./Ledger"
import axios from "axios";
import {useCallback, useEffect, useState} from "react";
import {CategoryType, LedgerType} from "../TypeList";
import "./Ledger.css";
import LedgerDetail from "./ledgerDetail";
import CreateCategory from "./CreateCategory";

interface JQuery {
    modal(action: 'show' | 'hide'): void;
}

export default function LedgerMain(){

    const [ledgerList, setLedgerList] = useState<LedgerType[]>([] );
    const [landingEvent , setLendingEvent] =  useState(false);
    const [categoryList, setCategoryList] = useState<CategoryType[]>([]);
    const [ledger, setLedger] = useState<LedgerType>();

    const ChangeEvent = () => {
        if (!landingEvent) {
            setLendingEvent(true);
        } else {
            setLendingEvent(false);
        }
    }

    useEffect(() => {
        axios.post("/api/ledger/LedgerList", JSON.stringify({
            userNo: sessionStorage.getItem("userNo")
        }), {
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            setLedgerList(res.data);
        })


        const usersDto = {
            userNo : sessionStorage.getItem("userNo"),
            userId : sessionStorage.getItem("userId")
        }

        axios.post("api/category/categoryList", JSON.stringify({usersDto}),
            { headers : {"Content-Type" : "application/json"}
            }).then(res => {
            setCategoryList(res.data);
        })

    }, [landingEvent]);


    function ledgertDetail(key  : number){
        axios.post("/api/ledger/ledgertDetail",JSON.stringify({
            fileManagerNo : key
        }), {
            headers : {
                "Content-Type" : "application/json"
            }
        }).then((res) => {
            setLedger(res.data);

            // @ts-ignore
            $("#ledgerDetail").modal("show");
        })
    }

    return(
        <div>
            <div>
                <CreateLeger ChangeEvent={ChangeEvent} categoryList={categoryList}/>
                <CreateCategory categoryList={categoryList}/>
            </div>
           <div className={"warp"}>
                {ledgerList.map((ledger: LedgerType, index: number) => (
                    <div className="card shadow-lg" key={index}>
                    <Ledger ledger={ledger} landingEvent={landingEvent} ledgertDetail={ledgertDetail} />
                    </div>
                ))}
                {ledger && <LedgerDetail categoryList={categoryList} ledger={ledger} ChangeEvent={ChangeEvent}/>}
            </div>
        </div>
    )
}