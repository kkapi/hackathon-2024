
import { ColumnDef } from "@tanstack/react-table"

type Profession = {
	profession: string;
};

export type Direction = {
	number: string;
	direction: string;
	contestGroup: string;
	placeBudget: number;
	placeContract: number;
	price: number;
	subjectOne: string;
	subjectTwo: string;
	subjectThree: string;
	minPointOne: number;
	minPointTwo: number;
	minPointThree: number;
	pointPreviousYear: number;
	contestBudget: number;
	contestContract: number;
	profession: Profession[];
};

export const columns: ColumnDef<Direction>[] = [
  {
    accessorKey: "number",
    header: "Номер направления",
  },
  {
    accessorKey: "direction",
    header: "Направление",
  },
  {
    accessorKey: "contestGroup",
    header: "Конкурсная группа",
  },
  {
    accessorKey: "placeBudget",
    header: "Количество бюджетных мест",
  },
  {
    accessorKey: "placeContract",
    header: "Количество контрактных мест",
  },
  {
    accessorKey: "price",
    header: "Цена",
  },
  {
    accessorKey: "subjectOne",
    header: "Предмет 1",
  },
  {
    accessorKey: "subjectTwo",
    header: "Предмет 2",
  },
  {
    accessorKey: "subjectThree",
    header: "Предмет 3",
  },
  {
    accessorKey: "minPointOne",
    header: "Минимальный балл 1",
  },
  {
    accessorKey: "minPointTwo",
    header: "Минимальный балл 2",
  },
  {
    accessorKey: "minPointThree",
    header: "Минимальный балл 3",
  },
  {
    accessorKey: "pointPreviousYear",
    header: "Проходной балл",
  },
  {
    accessorKey: "contestBudget",
    header: "Конкурс на бюджет",
  },
  {
    accessorKey: "contestContract",
    header: "Конкурс на контракт",
  },
  {
    accessorKey: "profession",
    header: "Профессии",
    cell: ({row}) => {
      const test = row.getValue('profession').map(test => test.profession);
      return <div>{test.join(' ')}</div>
    }
  },
  
]
