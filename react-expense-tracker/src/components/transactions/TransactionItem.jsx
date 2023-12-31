import { useGlobalState } from "../../context/GlobalState";

export function TransactionItem({ transaction }) {
    const {deleteTransact} = useGlobalState();

    return (
        <li className="bg-zinc-400 text-white px-3 py-1 rounded-lg mb-2 w-full flex justify-between items-center">
            <p className="text-sm">{transaction.description}</p>
            <div>
            <span>${transaction.amount}</span>
            <button onClick={() => {
                deleteTransact(transaction.id)
            }}
            >
                X
            </button>
            </div>
        </li>
    )
}

export default TransactionItem