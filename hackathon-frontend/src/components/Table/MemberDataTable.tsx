import React, { useState, useEffect } from 'react';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import axiosApi from '@/utils/axios/AxiosApi';

interface MemberInfo {
  memberId: number;
  name: string;
  age: number;
  joinedInsurance: string;
  summary: string;
}

interface ApiResponse {
  memberInfo: MemberInfo[];
}

const columns: GridColDef[] = [
  { field: 'name', headerName: 'Name', width: 150 },
  { field: 'age', headerName: 'Age', width: 110 },
  { field: 'joinedInsurance', headerName: 'Joined Insurance', width: 180 },
  { field: 'summary', headerName: 'Summary', width: 200, flex: 1 },
];

export default function MemberDataTable() {
  const [memberData, setMemberData] = useState<MemberInfo[]>([]);

  useEffect(() => {
    axiosApi
      // TODO: Change API url
      .get<ApiResponse>('/consultings/1')
      .then((response) => {
        if (response.status === 200) {
          return response.data as ApiResponse;
        } else {
          throw Error();
        }
      })
      .then((res) => {
        if (res.memberInfo) {
          setMemberData(res.memberInfo);
        } else {
          console.error('Invalid response structure');
          setMemberData([]);
        }
      })
      .catch((error) => {
        console.error('Failed to fetch member data:', error);
        setMemberData([]);
      });
  }, []);

  return (
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={memberData.map((info) => ({ ...info, id: info.memberId }))}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        disableRowSelectionOnClick
      />
    </div>
  );
}
