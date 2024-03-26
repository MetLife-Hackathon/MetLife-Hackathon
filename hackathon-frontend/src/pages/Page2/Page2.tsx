import Typography from '@mui/material/Typography';

import Meta from '@/components/Meta';
import { FullSizeCenteredFlexBox } from '@/components/styled';

function Page2() {
  // const [list, setList] = useState<ExampleModel[]>([]);
  // const [one, setOne] = useState<ExampleModel>({} as ExampleModel);
  // const [saved, setSaved] = useState<ExampleModel | null>(null);
  //
  // useEffect(() => {
  //   console.log(list);
  // }, [list]);
  //
  // useEffect(() => {
  //   console.log(one);
  // }, [one]);
  //
  // useEffect(() => {
  //   console.log(saved);
  // }, [saved]);
  //
  // const handleClickList = async () => {
  //   const data = await axiosApi.get<ExampleModel[]>('/api/many', {
  //     params: { asdf: 'sdf' },
  //     headers: { Accept: '', userId: '' },
  //   });
  //   setList(data.item);
  // };
  //
  // const handleClickOne = async () => {
  //   const data = await axiosApi.get<ExampleModel>('/api/one');
  //   setOne(data.item);
  // };
  //
  // const handleClickSave = async () => {
  //   const sample = {} as ExampleModel;
  //   const data = await axiosApi.post<ExampleModel>('/api/save', sample);
  //   setSaved(data.item);
  // };

  return (
    <>
      <Meta title="page 2" />
      <FullSizeCenteredFlexBox>
        <Typography variant="h3">Page 2</Typography>
        {/*<Button onClick={handleClickList}>list</Button>*/}
        {/*<Button onClick={handleClickOne}>one</Button>*/}
        {/*<Button onClick={handleClickSave}>save</Button>*/}
      </FullSizeCenteredFlexBox>
    </>
  );
}

export default Page2;
