type ExampleModel = {
  id: string;
  name: string;
  age: number;
  careers: Career[];
};

type Career = {
  company: string;
  year: number;
};

export type { ExampleModel };
