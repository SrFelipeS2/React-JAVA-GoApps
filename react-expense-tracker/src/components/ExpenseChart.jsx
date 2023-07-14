import { VictoryPie, VictoryLabel } from "victory"
import { useGlobalState } from "../context/GlobalState"

function ExpenseChart() {

  const {transactions} = useGlobalState()

  const totalIncome = transactions.filter(transaction=>transaction.amount > 0).reduce((acc, transaction)=>(acc+=transaction.amount),0);
  const totalExpense = transactions.filter(transaction=>transaction.amount < 0).reduce((acc, transaction)=>(acc+=transaction.amount),0)*-1;
  const total = transactions.reduce((acc, transaction)=>(acc += transaction.amount),0)
  
  const totalExpensesPercentage = Math.round((totalExpense/totalIncome)*100)
  const totalIncomePercentage = 100-totalExpensesPercentage;

    return (
        <div>
            <VictoryPie
            colorScale={["#E74C3C", "#2ECC71" ]}
                data={[
                    { x: "Expenses", y:  totalExpensesPercentage},
                    { x: "Incomes", y:  totalIncomePercentage},
                ]}
                animate={{
                    duration:1000
                }}
                labels={({datum})=>`${datum.y}%`}
                labelComponent={<VictoryLabel
                    angle={45}
                    style={{
                        fill:"white"
                    }}
                />}
            />
        </div>
    )
}

export default ExpenseChart