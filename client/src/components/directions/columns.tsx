import { ColumnDef } from '@tanstack/react-table';
import { Badge } from '../ui/badge';
import {
	Collapsible,
	CollapsibleContent,
	CollapsibleTrigger,
} from '../ui/collapsible';

import { ArrowUpDown, MoreHorizontal } from "lucide-react"
import { Button } from '../ui/button';


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
  professionString: string;
};

export const columns: ColumnDef<Direction>[] = [
	{
		accessorKey: 'number',
		header: 'Номер направления',
    cell: ({ row }) => {
			return <Badge variant="secondary">{row.getValue('number')}</Badge>
		},
	},
	{
		accessorKey: 'direction',
		header: 'Направление',
	},
	{
		accessorKey: 'contestGroup',
		header: 'Конкурсная группа',
	},
	{
		accessorKey: 'placeBudget',
		header: ({ column }) => {
      return (
        <Button
          variant="ghost"
          onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}
        >
          Бюджетные места
          <ArrowUpDown className="ml-2 h-4 w-4" />
        </Button>
      )
    },
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('placeBudget')}</div>
		},
	},
	{
		accessorKey: 'placeContract',
		header: ({ column }) => {
      return (
        <Button
          variant="ghost"
          onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}
        >
          Контрактные места
          <ArrowUpDown className="ml-2 h-4 w-4" />
        </Button>
      )
    },
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('placeContract')}</div>
		},
	},
	{
		accessorKey: 'price',
		header: ({ column }) => {
      return (
        <Button
          variant="ghost"
          onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}
        >
          Цена
          <ArrowUpDown className="ml-2 h-4 w-4" />
        </Button>
      )
    },
		cell: ({ row }) => {
			const amount = parseFloat(row.getValue('price'));
			const formatted = new Intl.NumberFormat('ru-RU', {
				style: 'currency',
				currency: 'RUB',
			}).format(amount);

			return <div className="text-center font-medium">{formatted}</div>;
		},
	},
	{
		accessorKey: 'subjectOne',
		header: 'Предмет 1',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('subjectOne')}</div>
		},
	},
	{
		accessorKey: 'subjectTwo',
		header: 'Предмет 2',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('subjectTwo')}</div>
		},
	},
	{
		accessorKey: 'subjectThree',
		header: 'Предмет 3',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('subjectThree')}</div>
		},
	},
	{
		accessorKey: 'minPointOne',
		header: 'Минимальный балл 1',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('minPointOne')}</div>
		},
	},
	{
		accessorKey: 'minPointTwo',
		header: 'Минимальный балл 2',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('minPointTwo')}</div>
		},
	},
	{
		accessorKey: 'minPointThree',
		header: 'Минимальный балл 3',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('minPointThree')}</div>
		},
	},
	{
		accessorKey: 'pointPreviousYear',
		header: ({ column }) => {
      return (
        <Button
          variant="ghost"
          onClick={() => column.toggleSorting(column.getIsSorted() === "asc")}
        >
          Проходной балл
          <ArrowUpDown className="ml-2 h-4 w-4" />
        </Button>
      )
    },
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('pointPreviousYear')}</div>
		},
	},
	{
		accessorKey: 'contestBudget',
		header: 'Конкурс на бюджет',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('contestBudget')}</div>
		},
	},
	{
		accessorKey: 'contestContract',
		header: 'Конкурс на контракт',
    cell: ({ row }) => {
			return <div className='text-center'>{row.getValue('contestContract')}</div>
		},
	},
	{
		accessorKey: 'profession',
		header: 'Профессии',
		cell: ({ row }) => {
			const test = row.getValue('profession').map(test => test.profession);
			if (test.length === 0) return;
			if (test.length === 1)
				return <Badge variant="secondary">{test[0]}</Badge>;
			// if (test.length < 2) return <Badge variant="secondary">{test.join('')}</Badge>
			const [trigger, ...rest] = test;
			return (
				<Collapsible>
					<CollapsibleTrigger>
						<Badge variant="secondary">{trigger} *</Badge>
					</CollapsibleTrigger>
					<CollapsibleContent>
						{rest.map((item, indx) => (
							<Badge key={indx} variant="secondary" className="mt-2">
								{item}
							</Badge>
						))}
					</CollapsibleContent>
				</Collapsible>
			);
		},
	},
];
