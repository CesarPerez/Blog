export interface Entry {
    id: string,
    title: string,
    text: string;
    creationDate: Date;
    comments: Comment[];
}
